import 'package:flutter/cupertino.dart';
import 'package:flutter/material.dart';

class ThemeProvider extends ChangeNotifier{
  ThemeData currentTheme;

  ThemeProvider({required bool isDarkMode}) : currentTheme = isDarkMode ? ThemeData.dark() : ThemeData.light();

  setLightMode(){
    currentTheme = ThemeData.light();
    notifyListeners();
  }

  setDarkModer(){
    currentTheme = ThemeData.dark();
    notifyListeners();
  }
}