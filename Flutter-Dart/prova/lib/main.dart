import 'package:flutter/material.dart';
import 'package:prova/pages/selectorpagines.dart';

import 'pages/menu_foto.dart';

void main() {
  runApp(const MyApp());
}

class MyApp extends StatelessWidget {
  const MyApp({super.key});

  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      title: 'Provaes de imatges',
      theme: ThemeData(
        primarySwatch: Colors.blue,
        scaffoldBackgroundColor: Color(0xFF265c85),
      ),
      home: const SelecPage(title: 'Provaes de imatges'),
    );
  }
}
