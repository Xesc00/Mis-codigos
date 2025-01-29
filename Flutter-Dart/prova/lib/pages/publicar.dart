import 'dart:convert';
import 'dart:io';

import 'package:dio/dio.dart';
import 'package:flutter/cupertino.dart';
import 'package:flutter/material.dart';
import 'package:prova/pages/zoom_foto.dart';
import 'package:http/http.dart' as http;

import 'menu_selecio.dart';

class Publisher extends StatefulWidget {
  const Publisher({super.key, required this.img});
  final File img;

  @override
  State<Publisher> createState() => _Publisher();
}

String tit = "", des = "";
late File tmpFile;
String base64Image = "";
String status = '';

Widget imgShow(context, size, img) {
  return FutureBuilder<File>(
      builder: (BuildContext context, AsyncSnapshot<File> snapshot) {
    return GestureDetector(
        onTap: () {
          Navigator.of(context).push(MaterialPageRoute(
              builder: (context) => ZoomFoto(
                    img: img,
                  )));
        },
        child: Container(
            margin: const EdgeInsets.all(20),
            width: size.width * 0.3,
            child: ClipRRect(
              borderRadius: BorderRadius.circular(40),
              child: Image.file(
                img,
              ),
            )));
    tmpFile = snapshot.data!;
    base64Image = base64Encode(snapshot.data!.readAsBytesSync());
  });
}

Widget fieldText(texto, _color) {
  return TextField(
    textAlignVertical: TextAlignVertical.top,
    expands: true,
    minLines: null,
    maxLines: null,
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

class _Publisher extends State<Publisher> {
  Color _color = Color(0xFFbdd7ff);

  @override
  Widget build(BuildContext context) {
    var mediaQuery = MediaQuery.of(context);
    Size size = mediaQuery.size;

    return Scaffold(
      body: ListView(
        children: [
          Row(children: <Widget>[
            imgShow(context, size, widget.img),
            Container(
              margin: const EdgeInsets.all(5),
              width: size.width * 0.54,
              height: size.height * 0.15,
              child: fieldText(
                'Titulo',
                _color,
              ),
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
                  } else
                    insertOne(tit, widget.img, des);
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

  Future insertOne(tt, foto, des) async {
    String filname = "pullOne.php";
    Uri url = Uri.parse('http://192.168.18.75/public_html/' + filname);
    String fname = foto!.path.split('/').last;

    try {
      http.Response response = await http.post(url,
          headers: {"Accept": "application/json"},
          body: {"titulo": '$tt', "foto": '$fname', "desc": '$des'});

      uploadImg(fname);
    } catch (e) {
      print(e);
    }
  }

//Funciona pero no se pot veura s'imatge
  // upload(String filename) {
  //   http.post(Uri.parse('http://192.168.18.75/public_html/subir_imagen.php'),
  //       body: {
  //         "image": base64Image,
  //         "name": filename,
  //       }).then((result) {});
  // }

  Future<void> uploadImg(fname) async {
    String msg;
    Dio dio = new Dio();
    String filname = "uploadimg.php";
    String url = 'http://192.168.18.75/public_html/' + filname;
    try {
      FormData fromData = new FormData.fromMap({
        'file': await MultipartFile.fromFile(widget.img!.path, filename: fname)
      });

      List<int> imgaeBytes = widget.img.readAsBytesSync();
      String baseImage = base64Encode(imgaeBytes);
      var response = await dio.post(url, data: fromData).then((value) {
        if (value.toString() == '1') {
          msg = 'Se ha subido correctamente';
          print(msg);
          showDialog(
              context: context,
              builder: (BuildContext context) => infoUpload(msg));
        } else {
          msg = 'Error: ' + value.toString();
          print(msg);
          showDialog(
              context: context,
              builder: (BuildContext context) => infoUpload(msg));
        }
      });
    } catch (e) {
      print(e);
    }
  }
}
