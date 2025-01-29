import 'package:flutter/material.dart';

class HomePageTemp extends StatelessWidget {
  final elements = ['Element 1', 'Element 2', 'Element 3', 'Element 4'];

  @override
  Widget build(BuildContext context) {
    return Scaffold(
        appBar: AppBar(
          title: Text('Components Temp'),
        ),
        body: ListView(
          children: _crearElementCurt(),
        )
        /*(
        children: [
          ListTile(
            title: Text('Titol ListTile'),
          ),
          Divider(),
          ListTile(
            title: Text('Titol ListTile'),
          ),
          Divider(),
          ListTile(
            title: Text('Titol ListTile'),
          ),
          Divider(),
          ListTile(
            title: Text('Titol ListTile'),
          )
        ],
      ),*/
        );
  }

  List<Widget> _crearElement() {
    List<Widget> llista = [];

    for (String element in elements) {
      final tempWidget = ListTile(
        title: Text(element),
      );

      llista.add(tempWidget);
      llista.add(Divider());
    }

    return llista;
  }

  List<Widget> _crearElementCurt() {
    var widgets = elements.map((element) {
      return Column(
        children: [
          ListTile(title: Text(element), subtitle: Text('UwU')),
        ],
      );
    });
    return widgets.toList();
  }
}