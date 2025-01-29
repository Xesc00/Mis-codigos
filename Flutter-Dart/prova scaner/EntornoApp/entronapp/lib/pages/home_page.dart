import 'package:entronapp/pages/selector.dart';
import 'package:flutter/cupertino.dart';
import 'package:flutter/material.dart';
import 'package:flutter/cupertino.dart';
import 'package:flutter/material.dart';
import 'package:flutter_blue_plus/flutter_blue_plus.dart';
import 'package:get/get.dart';
import 'package:get/get_connect/http/src/utils/utils.dart';

import '../controllers/bluetooth_controller.dart';
import 'lector_bluetooth.dart';
import 'lectura_scaner.dart';

class HomePage extends StatelessWidget {
  const HomePage({Key? key}) : super(key: key);

  @override
  Widget build(BuildContext context) {
    return Scaffold(
        body: Center(
            child: Column(
                mainAxisAlignment: MainAxisAlignment.center,
                crossAxisAlignment: CrossAxisAlignment.center,
                children: [
          ElevatedButton(
            style: TextButton.styleFrom(
              primary: Color.fromARGB(255, 255, 255, 255),
            ),
            onPressed: () {
              Navigator.push(
                  context,
                  MaterialPageRoute(
                      builder: (context) => LecturaScaner(title: 't')));
            },
            child: Text('Lector codi de barres'),
          ),
          ElevatedButton(
            style: TextButton.styleFrom(
              primary: Color.fromARGB(255, 255, 255, 255),
            ),
            onPressed: () {
              Navigator.push(context,
                  MaterialPageRoute(builder: (context) => const Selector()));
            },
            child: Text('Apliació entorn visual'),
          )
        ])));
  }
}
