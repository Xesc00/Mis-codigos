import 'dart:convert';
import 'dart:io';

import 'package:flutter/cupertino.dart';
import 'package:flutter/material.dart';
import 'package:http/http.dart' as http;

import 'menu_foto.dart';
import 'menu_selecio.dart';

class SelecPage extends StatefulWidget {
  const SelecPage({super.key, required this.title});
  final String title;

  @override
  State<SelecPage> createState() => _SelecPage();
}

class _SelecPage extends State<SelecPage> {
  @override
  Widget build(BuildContext context) {
    return Scaffold(
        body: Center(
      child: Column(
          mainAxisAlignment: MainAxisAlignment.center,
          crossAxisAlignment: CrossAxisAlignment.center,
          children: [
            ElevatedButton(
              onPressed: () {
                //insertOne();
                getData();
              },
              child: Text('Selector'),
            ),
            ElevatedButton(
              onPressed: () {
                print('Selector');
                Navigator.of(context).push(
                    MaterialPageRoute(builder: (context) => MenuSelecio()));
              },
              child: Text('Images'),
            ),
          ]),
    ));
  }
}

Future getData() async {
  String filname = "getAll.php";
  Uri url = Uri.parse('http://192.168.18.75/public_html/' + filname);

  try {
    http.Response response = await http.get(url);
    var data = jsonDecode(response.body);
    print(data.toString());
  } catch (e) {
    print(e);
  }
}

Future insertOne() async {
  String filname = "pullOne.php";
  Uri url = Uri.parse('http://192.168.18.75/public_html/' + filname);

  try {
    http.Response response = await http.post(url,
        headers: {"Accept": "application/json"},
        body: {"titulo": 'titulo', "foto": 'FFFFF', "desc": 'DEEESS'});

    var res = jsonDecode(response.body);

    print(res);
  } catch (e) {
    print(e);
  }
}
