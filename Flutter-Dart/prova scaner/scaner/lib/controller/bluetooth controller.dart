import 'package:flutter_blue_plus/flutter_blue_plus.dart';
import 'package:get/get.dart';

class BLuetoothContrller extends GetxController {
  FlutterBluePlus flutterBlue = FlutterBluePlus.instance;

  //Escanea dispositivos bluetooth
  Future scanDivices() async {
    //Tiempo de escaneo
    flutterBlue.startScan(timeout: const Duration(seconds: 5));

    flutterBlue.stopScan();
    print(flutterBlue.scanResults);
  }

  //Getter de es dispositius trobats
  Stream<List<ScanResult>> get scanResult => flutterBlue.scanResults;
}
