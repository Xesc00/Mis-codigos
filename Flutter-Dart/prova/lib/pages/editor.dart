import 'dart:convert';
import 'dart:io';

import 'package:dio/dio.dart';
import 'package:flutter/cupertino.dart';
import 'package:flutter/material.dart';
import 'package:prova/pages/datospost.dart';
import 'package:prova/pages/zoom_foto.dart';
import 'package:http/http.dart' as http;

import 'menu_selecio.dart';

class Editor extends StatefulWidget {
  const Editor({super.key, required this.datos_post});
  final Datos_Post datos_post;

  @override
  State<Editor> createState() => _Editor();
}

String tit = "", des = "";
late File tmpFile;
String base64Image = "";
String status = '';

Widget fieldText(texto, _color, datos_post) {
  return TextField(
    textAlignVertical: TextAlignVertical.top,
    expands: true,
    minLines: null,
    maxLines: null,
    controller: TextEditingController(text: datos_post.titulo),
    decoration: InputDecoration(
        border: OutlineInputBorder(borderRadius: BorderRadius.circular(20)),
        labelText: texto,
        filled: true,
        fillColor: _color,
        labelStyle: TextStyle(fontSize: 30, color: Colors.black)),
    onChanged: (value) {
      tit = value;
    },
  );
}

InputDecoration decoDes(_color) {
  return InputDecoration(
      border: OutlineInputBorder(borderRadius: BorderRadius.circular(20)),
      labelText: 'Descripcion',
      filled: true,
      fillColor: _color,
      labelStyle: TextStyle(fontSize: 30, color: Colors.black));
}

class _Editor extends State<Editor> {
  Color _color = Color(0xFFbdd7ff);

  @override
  Widget build(BuildContext context) {
    var mediaQuery = MediaQuery.of(context);
    Size size = mediaQuery.size;

    return Scaffold(
      body: ListView(
        children: [
          Row(children: <Widget>[
            Container(
              margin: const EdgeInsets.all(5),
              width: size.width * 0.54,
              height: size.height * 0.15,
              child: fieldText('Titulo', _color, widget.datos_post),
            )
          ]),
          Row(
            mainAxisAlignment: MainAxisAlignment.center,
            children: <Widget>[
              Expanded(
                  child: Container(
                margin: const EdgeInsets.all(10),
                //padding: const EdgeInsets.symmetric(vertical: ),
                width: size.width * 0.9,
                height: size.height * 0.4,
                child: TextField(
                  textAlignVertical: TextAlignVertical.top,
                  expands: true,
                  minLines: null,
                  maxLines: null,
                  controller: TextEditingController(
                      text: widget.datos_post.descripcion),
                  decoration: decoDes(_color),
                  onChanged: (value) {
                    des = value;
                  },
                ),
              ))
            ],
          ),
          Container(
              padding: EdgeInsets.only(left: 115, right: 115),
              child: ElevatedButton(
                onPressed: () {
                  if (tit == "" || tit == null && des == "" || des == null) {
                    showDialog(
                        context: context,
                        builder: (BuildContext context) => alertDialog());
                    print(
                        'Els camps de Titol i/o Descipcio no poden estar buits');
                  } else {
                    updateOne(tit, des);
                    print("update");
                  }
                },
                child: Text('Publicar'),
              ))
        ],
      ),
    );
  }

  Widget alertDialog() => CupertinoAlertDialog(
        title: Text('Alert'),
        content: Text('Has de posar algo com a titol i/o descripcio'),
        actions: [
          CupertinoDialogAction(
            isDefaultAction: true,
            child: Text("Okey"),
            onPressed: () {
              print("okey");
              Navigator.of(context).pop();
            },
          )
        ],
      );

  Widget infoUpload(msg) => CupertinoAlertDialog(
        title: Text('Upload'),
        content: Text(msg),
        actions: [
          CupertinoDialogAction(
            isDefaultAction: true,
            child: Text("Okey"),
            onPressed: () {
              print("okey");
              Navigator.of(context)
                  .push(MaterialPageRoute(builder: (context) => MenuSelecio()));
            },
          )
        ],
      );

  Future updateOne(tt, des) async {
    String filname = "update.php";
    Uri url = Uri.parse('http://192.168.18.75/public_html/' + filname);
    int? id = widget.datos_post.id;

    try {
      http.Response response = await http.post(url,
          headers: {"Accept": "application/json"},
          body: {"id": '$id', "titulo": '$tt', "desc": '$des'});

      print("$tit || $des || " + id.toString());
    } catch (e) {
      print(e);
    }
  }

  // Future<void> uploadImg(fname) async {
  //   String msg;
  //   Dio dio = new Dio();
  //   String filname = "uploadimg.php";
  //   String url = 'http://192.168.18.75/public_html/' + filname;
  //   try {
  //     FormData fromData = new FormData.fromMap({
  //       'file': await MultipartFile.fromFile(widget.img!.path, filename: fname)
  //     });

  //     List<int> imgaeBytes = widget.img.readAsBytesSync();
  //     String baseImage = base64Encode(imgaeBytes);
  //     var response = await dio.post(url, data: fromData).then((value) {
  //       if (value.toString() == '1') {
  //         msg = 'Se ha subido correctamente';
  //         print(msg);
  //         showDialog(
  //             context: context,
  //             builder: (BuildContext context) => infoUpload(msg));
  //       } else {
  //         msg = 'Error: ' + value.toString();
  //         print(msg);
  //         showDialog(
  //             context: context,
  //             builder: (BuildContext context) => infoUpload(msg));
  //       }
  //     });
  //   } catch (e) {
  //     print(e);
  //   }
  // }
}
