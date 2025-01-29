import 'package:flutter/material.dart';
import 'package:need_widget/src/pages/alert_page.dart';
import 'package:need_widget/src/pages/avatar_page.dart';
import 'package:need_widget/src/pages/home_temp.dart';
import 'package:need_widget/src/pages/rutes/rutes.dart';

import 'src/pages/home_page.dart';

void main() => runApp(MyApp());

class MyApp extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      debugShowCheckedModeBanner: false,
      title: 'Components',
      home: HomePage(),
      initialRoute: '/',
      routes: getRoutes(),
      onGenerateRoute: (RouteSettings settings) {
        print('Estas a ${settings.name}');
        return MaterialPageRoute(
            builder: (BuildContext context) => AlertPage());
      },
    );
  }
}