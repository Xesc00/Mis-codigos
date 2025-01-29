import 'dart:convert';
import 'package:flutter/services.dart' show rootBundle;

class _MenuProvider {
  List<dynamic> opcions = [];
  _MenuProvider() {
    CarregarDades();
  }

  CarregarDades() {
    rootBundle.loadString('data/menu_opts.json').then((data) {
      Map dataMap = json.decode(data);

      print(dataMap);

      opcions = dataMap['rutes'];
      return opcions;
    });
  }
}

final menuProvider = new _MenuProvider();