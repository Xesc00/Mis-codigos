// ignore_for_file: prefer_const_constructors

import 'dart:io';

import 'package:flutter/material.dart';
import 'package:image_picker/image_picker.dart';

class MenuFoto extends StatefulWidget {
  const MenuFoto({super.key, required this.title});
  final String title;

  @override
  State<MenuFoto> createState() => _MenuFoto();
}

class _MenuFoto extends State<MenuFoto> {
  String imagePath = "";

  var imagen = File(
      '/data/user/0/com.example.prova/cache/image_picker3408262001991087909.jpg');
  final picker = ImagePicker();

  opciones(context) {
    showDialog(
        context: context,
        builder: (BuildContext context) {
          return AlertDialog(
            contentPadding: EdgeInsets.all(0),
            content: SingleChildScrollView(
                child: Column(
              children: [
                InkWell(
                  onTap: () async {
                    var pickedFile;
                    pickedFile =
                        await picker.getImage(source: ImageSource.gallery);

                    setState(() {
                      if (pickedFile != null) {
                        imagen = File(pickedFile.path);
                        print(imagen);
                      } else {}
                    });
                  },
                  child: Container(
                      // ignore: prefer_const_constructors
                      padding: EdgeInsets.all(20),
                      decoration: BoxDecoration(
                          border: Border(
                              bottom:
                                  BorderSide(width: 1, color: Colors.grey))),
                      child: Row(
                        // ignore: prefer_const_literals_to_create_immutables
                        children: [
                          Expanded(
                              child: Text('Galerya',
                                  style: TextStyle(fontSize: 16))),
                          Icon(Icons.image)
                        ],
                      )),
                ),
                InkWell(
                  onTap: () async {
                    var pickedFile;
                    pickedFile =
                        await picker.getImage(source: ImageSource.camera);

                    setState(() {
                      if (pickedFile != null) {
                        imagen = File(pickedFile.path);
                        print(imagen);
                      } else {}
                    });
                  },
                  child: Container(
                      // ignore: prefer_const_constructors
                      padding: EdgeInsets.all(20),
                      decoration: BoxDecoration(
                          border: Border(
                              bottom:
                                  BorderSide(width: 1, color: Colors.grey))),
                      child: Row(
                        // ignore: prefer_const_literals_to_create_immutables
                        children: [
                          Expanded(
                              child: Text('Camara',
                                  style: TextStyle(fontSize: 16))),
                          Icon(Icons.camera_alt)
                        ],
                      )),
                )
              ],
            )),
          );
        });
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
        appBar: AppBar(
          title: Text(widget.title),
        ),
        body: ListView(
          children: [
            Padding(
              padding: EdgeInsets.all(20),
              child: Column(children: [
                ElevatedButton(
                  onPressed: () {
                    opciones(context);
                  },
                  child: Text('Select img'),
                ),
                SizedBox(
                  height: 10,
                ),
                ClipRRect(
                    borderRadius: BorderRadius.circular(40),
                    child: imagen == null ? Center() : Image.file(imagen)),
              ]),
            )
          ],
        ));
  }
}
