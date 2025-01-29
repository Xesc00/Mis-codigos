import 'dart:io';

import 'package:flutter/cupertino.dart';
import 'package:flutter/material.dart';

class ZoomFoto extends StatefulWidget {
  const ZoomFoto({super.key, required this.img});
  final File img;

  @override
  State<ZoomFoto> createState() => _ZoomFoto();
}

class _ZoomFoto extends State<ZoomFoto> {
  @override
  Widget build(BuildContext context) {
    return Scaffold(
        appBar: AppBar(
          title: Text('Imagen'),
        ),
        body: Column(
          mainAxisAlignment: MainAxisAlignment.center,
          crossAxisAlignment: CrossAxisAlignment.center,
          children: [Image.file(widget.img)],
        ));
  }
}
