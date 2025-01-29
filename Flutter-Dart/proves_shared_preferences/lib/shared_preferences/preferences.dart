import 'package:shared_preferences/shared_preferences.dart';

class Preferences {
  static late SharedPreferences _prefs;

  static String _email = '';
  static String _pasw = '';
  static bool _issave = false;

  static Future init() async {
    _prefs = await SharedPreferences.getInstance();
  }

  static String get email {
    return _prefs.getString('email') ?? _email;
  }

  static set email(String value) {
    _email = value;
    _prefs.setString('email', value);
  }

  static bool get isSave {
    return _prefs.getBool('save') ?? _issave;
  }

  static set isSave(bool value) {
    _issave = value;
    _prefs.setBool('save', value);
  }

  static String get pasword {
    return _prefs.getString('contrasenya') ?? _pasw;
  }

  static set pasword(String value) {
    _pasw = value;
    _prefs.setString('contrasenya', value);
  }
}
