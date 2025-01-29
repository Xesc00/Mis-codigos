import 'package:flutter/cupertino.dart';
import 'package:flutter/material.dart';
import 'package:flutter_barcode_listener/flutter_barcode_listener.dart';
import 'package:visibility_detector/visibility_detector.dart';

class LecturaScaner extends StatefulWidget {
  LecturaScaner({Key? key, required this.title}) : super(key: key);

  final String title;

  @override
  _LecturaScaner createState() => _LecturaScaner();
}

class _LecturaScaner extends State<LecturaScaner> {
  String? _barcode;
  late bool visible;

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
            onBarcodeScanned: (barcode) {
              if (!visible) return;
              print(barcode);
              setState(() {
                _barcode = barcode;
              });
            },
            child: Column(
              mainAxisAlignment: MainAxisAlignment.center,
              crossAxisAlignment: CrossAxisAlignment.center,
              children: <Widget>[
                Text(
                  _barcode == null ? 'SCAN BARCODE' : 'BARCODE: $_barcode',
                  style: Theme.of(context).textTheme.headline5,
                ),
              ],
            ),
          ),
        ),
      ),
    );
  }
}
