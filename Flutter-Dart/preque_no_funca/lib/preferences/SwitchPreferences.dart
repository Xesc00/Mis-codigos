import 'package:shared_preferences/shared_preferences.dart';

class SwitchPreferences{
  static late SharedPreferences _prefs;

  static bool _isDarkMode = false;
  static int _genere = 1;

  static Future init() async{
    _prefs = await SharedPreferences.getInstance();
  }

  static bool get isDarkModer{
    return _prefs.getBool('darkmode') ?? _isDarkMode;
  }
  static set isDarkModer(value){
    _isDarkMode = value;
    _prefs.setBool('darkmode', value);
  }
  static int get genere{
    return _prefs.getInt('genere') ?? _genere;
  }
  static set genere(value){
    _genere = value;
    _prefs.setInt('genere', value);
  }
}