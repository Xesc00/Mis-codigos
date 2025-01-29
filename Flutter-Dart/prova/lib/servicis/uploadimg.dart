import 'dart:io';

import 'package:http/http.dart' as http;

class UploadServices {
  static var client = http.Client();
  static String apiURL = "http://192.168.18.75/wordpress";

  static Future<bool> uploadImg(filepath) async {
    String url = "$apiURL/wp-json/wp/v2/media";

    String fileName = filepath.path.split("/").last;

    Map<String, String> requestHeaders = {
      'Content-Type': 'image/jpeg',
      'Content-Disposition': 'attachment: filename=$fileName'
    };

    List<int> imageBytes = File(filepath.path).readAsBytesSync();
    var request = http.Request('POST', Uri.parse(url));
    request.headers.addAll(requestHeaders);
    request.bodyBytes = imageBytes;
    var res = await request.send();

    return res.statusCode == 201 ? true : false;
  }
}
