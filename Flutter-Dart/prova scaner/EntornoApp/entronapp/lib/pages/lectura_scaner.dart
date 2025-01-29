import 'package:flutter/cupertino.dart';
import 'package:flutter/material.dart';
import 'package:flutter_barcode_listener/flutter_barcode_listener.dart';
import 'package:visibility_detector/visibility_detector.dart';

import 'lector_bluetooth.dart';

class LecturaScaner extends StatefulWidget {
  LecturaScaner({Key? key, required this.title}) : super(key: key);

  final String title;

  @override
  _LecturaScaner createState() => _LecturaScaner();
}

class _LecturaScaner extends State<LecturaScaner> {
  String? _barcode;
  late bool visible;
  String a = "";
  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: Text(widget.title),
      ),
      body: Center(
        // Add visiblity detector to handle barcode
        // values only when widget is visible
        child: VisibilityDetector(
          onVisibilityChanged: (VisibilityInfo info) {
            visible = info.visibleFraction > 0;
          },
          key: Key('visible-detector-key'),
          child: BarcodeKeyboardListener(
            bufferDuration: Duration(milliseconds: 200),
            onBarcodeScanned: (code) {
              if (!visible) return;
              print(code);
              // print(AsciiEncoder(barcode));
              final String barcode = code;
              print(code);
              // print(barcode.codeUnits);
              // print(barcode.characters);
              // print(barcode.hashCode);
              // print(barcode.codeUnits.length);
              setState(() {
                _barcode = barcode;
              });
            },
            child: Column(
              mainAxisAlignment: MainAxisAlignment.center,
              crossAxisAlignment: CrossAxisAlignment.center,
              children: <Widget>[
                Text(_barcode == null ? 'Escanea' : 'Codi: '),
              ],
            ),
          ),
        ),
      ),
      floatingActionButton: FloatingActionButton(
        onPressed: () {
          Navigator.push(context,
              MaterialPageRoute(builder: (context) => LectroBluetotth()));
        },
      ),
    );
  }
}
