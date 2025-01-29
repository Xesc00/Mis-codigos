import 'package:entronapp/pages/carga_manual.dart';
import 'package:flutter/material.dart';

class Selector extends StatefulWidget {
  const Selector({super.key});

  @override
  State<StatefulWidget> createState() => _selector();
}

late BuildContext con;

class _selector extends State<Selector> {
  @override
  Widget build(BuildContext context) {
    con = context;
    return Scaffold(
      appBar: AppBar(
        leading: IconButton(
          icon: Icon(Icons.arrow_back, color: Colors.black),
          onPressed: () => Navigator.of(context).pop(),
        ),
      ),
      body: Column(
        crossAxisAlignment: CrossAxisAlignment.center,
        children: <Widget>[
          Row(children: <Widget>[
            SizedBox(height: 100),
            productInsert('LECTURA\nGALLETA', 1),
            productInsert('LECTURA\nMERCADERIA', 1),
            productInsert('CARGA\nMANUAL', 0),
          ]),
          botoSimp('VALIDA CARGA', 0.98),
          botoSimp('LISTADO CARGA', 0.98),
          botoSimp('RESTABLECER VALIDACION', 0.98),
          botoSimp('COMPROBACION STOCK APP VS NAV2018', 0.98),
        ],
      ),
    );
    throw UnimplementedError();
  }

  late double mq = MediaQuery.of(con).size.width;

  Widget productInsert(txt, i) {
    return Container(
        margin: EdgeInsets.only(left: 10),
        width: mq * .295,
        child: ElevatedButton.icon(
          onPressed: () {
            Navigator.push(context,
                MaterialPageRoute(builder: (context) => const Carga_manual()));
          },
          icon: Icon(i == 0
              ? Icons.back_hand
              : Icons.barcode_reader), //icon data for elevated button
          label: Text('$txt',
              textAlign: TextAlign.center,
              style: TextStyle(
                fontSize: 10,
              )),
          style: ElevatedButton.styleFrom(
            padding:
                EdgeInsets.only(top: 15.0, bottom: 15.0, left: 5, right: 5),
          ),
        ));
  }

  Widget botoSimp(txt, tamano) {
    return Container(
        margin: EdgeInsets.only(top: mq * .02, right: mq * .03, left: mq * .03),
        width: mq * tamano,
        child: ElevatedButton(
          onPressed: () {},
          child: Text('$txt',
              textAlign: TextAlign.center,
              style: TextStyle(fontSize: 14, fontWeight: FontWeight.bold)),
          style: ElevatedButton.styleFrom(
            padding:
                EdgeInsets.only(top: 25.0, bottom: 25.0, left: 5, right: 5),
          ),
        ));
  }
}
