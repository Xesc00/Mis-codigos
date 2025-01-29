import 'package:flutter/material.dart';
import 'package:need_widget/src/providers/menus_providers.dart';
import 'package:need_widget/src/utils/icona_string_util.dart';

import 'alert_page.dart';

class HomePage extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: Text('Components'),
      ),
      body: _llista(),
    );
  }

  Widget _llista() {
    //menuProvider.CarregarDades

    return FutureBuilder(
      future: menuProvider.CarregarDades(),
      initialData: [],
      builder: (context, AsyncSnapshot<List<dynamic>> snapshot) {
        print('Builder: ');
        print(snapshot.data);

        return ListView(
          children: _llistaElements(context, snapshot.data),
        );
      },
    );
    //return Column(
    //children: [
    //ListTile(title: Text('a'), subtitle: Text('UwU')),
    //],
    //);
  }

  List<Widget> _llistaElements(BuildContext context, List<dynamic>? data) {
    final List<Widget> elements = [];

    data?.forEach((element) {
      final widgetTemp = ListTile(
        title: Text(element['texte']),
        leading: getIcon(element['icona']),
        trailing: Icon(
          Icons.keyboard_arrow_right,
          color: Colors.blue,
        ),
        onTap: () {
          final route = MaterialPageRoute(builder: (context) => AlertPage());
          Navigator.pushNamed(context, element['ruta']);
        },
      );
      elements
        ..add(widgetTemp)
        ..add(Divider());
    });
    return elements;
  }
}