import 'package:flutter/material.dart';

import 'screens/screens.dart';

void main() async {
  WidgetsFlutterBinding.ensureInitialized();
  // await Preferences.init();
  // runApp(MultiProvider(providers: [
  //   ChangeNotifierProvider(
  //       create: (_) => LoginProvider(save: false, semail: '', spsw: '')),
  //   ChangeNotifierProvider(create: (_) => DespesasListProvider())
  child: MyApp();
}

class MyApp extends StatelessWidget {
  const MyApp({Key? key}) : super(key: key);

  // This widget is the root of your application.
  @override
  Widget build(BuildContext context) {
    return MaterialApp(
        debugShowCheckedModeBanner: false,
        title: 'Flutter Demo',
        theme: ThemeData(
          primarySwatch: Colors.blue,
        ),
        home: LoginScreen());
  }
}
