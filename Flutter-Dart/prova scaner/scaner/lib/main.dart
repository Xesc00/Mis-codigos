import 'dart:convert';
import 'dart:math';

import 'package:flutter/material.dart';
import 'package:scaner/views/home_page.dart';
import 'package:flutter_barcode_listener/flutter_barcode_listener.dart';
import 'package:visibility_detector/visibility_detector.dart';
import 'package:gs1_barcode_parser/gs1_barcode_parser.dart';

void main() {
  runApp(const MyApp());
}

class MyApp extends StatelessWidget {
  const MyApp({super.key});
  // This widget is the root of your application.
  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      title: 'Barcode Scanner Demo',
      theme: ThemeData(
        primarySwatch: Colors.blue,
        visualDensity: VisualDensity.adaptivePlatformDensity,
      ),
      home: MyHomePage(title: 'Barcode Scanner Demo'),
    );
  }
}

class MyHomePage extends StatefulWidget {
  MyHomePage({Key? key, required this.title}) : super(key: key);

  final String title;

  @override
  _MyHomePageState createState() => _MyHomePageState();
}

class _MyHomePageState extends State<MyHomePage> {
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
              final parser = GS1BarcodeParser.defaultParser();
              final result = parser.parse(barcode);
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
          // Navigator.push(
          //     // context, MaterialPageRoute(builder: (context) => HomePage())
          //     );
        },
      ),
    );
  }
}
