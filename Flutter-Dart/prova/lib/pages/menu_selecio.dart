import 'dart:io';

import 'package:flutter/cupertino.dart';
import 'package:flutter/material.dart';
import 'package:image_picker/image_picker.dart';
import 'package:prova/pages/publicar.dart';
import 'dart:convert';
import 'datospost.dart';
import 'package:http/http.dart' as http;

import 'editor.dart';

class MenuSelecio extends StatefulWidget {
  @override
  State<MenuSelecio> createState() => _MenuSelecio();
}

late Size size;

Widget alertLoad() {
  return Container(
      child: Center(
    child: Text(
      'Error de carga',
      style: TextStyle(fontSize: 16),
    ),
  ));
}

Widget cardImg(context, data) {
  Datos_Post dt = data;
  return GestureDetector(
      onTap: () {
        Navigator.of(context).push(MaterialPageRoute(
            builder: (context) => Editor(
                  datos_post: data,
                )));
      },
      child: Container(
          height: 270,
          width: size.width,
          padding: EdgeInsets.all(10),
          child: Card(
            margin: const EdgeInsets.all(10),
            shape:
                RoundedRectangleBorder(borderRadius: BorderRadius.circular(30)),
            shadowColor: Colors.black,
            elevation: 20,
            child: Column(children: [
              ClipRRect(
                borderRadius: BorderRadius.circular(30),
                child: Icon(
                  Icons.image_rounded,
                  size: 100,
                ),
              ),
              ListTile(
                title: Text(dt.titulo),
                subtitle: Text(dt.descripcion),
              )
            ]),
          )));
}

Widget floatingCamera(context) {
  final picker = ImagePicker();

  return FloatingActionButton.extended(
      onPressed: () async {
        var pickedFile;
        File imagen;
        pickedFile = await picker.getImage(source: ImageSource.camera);

        if (pickedFile != null) {
          imagen = File(pickedFile.path);
          Navigator.of(context).push(
              MaterialPageRoute(builder: (context) => Publisher(img: imagen)));
        } else {
          AlertDialog(
            title: Text('Error'),
            content: Text('Seleciona una imagen'),
          );
        }
      },
      label: const Text('Subir'),
      backgroundColor: Color.fromARGB(255, 164, 164, 164),
      icon: const Icon(Icons.camera_alt));
}

class _MenuSelecio extends State<MenuSelecio> {
  List<Datos_Post> data = [];
  Future<List<Datos_Post>> takeInfo() async {
    Uri url = Uri.parse('http://192.168.18.75/public_html/getAll.php');

    var response = await http.post(url).timeout(Duration(seconds: 90));
    var datos = jsonDecode(response.body);

    List<Datos_Post> registros = [];

    for (datos in datos) {
      registros.add(Datos_Post.fromJson(datos));
    }

    return registros.reversed.toList();
  }

  @override
  void initState() {
    super.initState();
    takeInfo().then((value) {
      setState(() {
        data.addAll(value);
      });
    });
  }

  @override
  Widget build(BuildContext context) {
    var mediaQuery = MediaQuery.of(context);

    size = mediaQuery.size;
    print(data.length);
    if (data.length == 0) {
      return Scaffold(
        body: Container(child: alertLoad()),
        floatingActionButton: floatingCamera(context),
      );
    } else {
      return Scaffold(
        body: Column(children: [
          Expanded(
            child: ListView.builder(
                itemCount: data.length,
                itemBuilder: (BuildContext context, int index) {
                  return cardImg(context, data[index]);
                }),
          ),
        ]),
        floatingActionButton: floatingCamera(context),
      );
    }
  }
}
