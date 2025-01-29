import 'package:flutter/material.dart';

const List<String> list = <String>['', '024', '311', '117', '151'];

class Carga_manual extends StatefulWidget {
  const Carga_manual({super.key});

  @override
  State<StatefulWidget> createState() => _carga_manual();
}

late BuildContext con;
late double mq = MediaQuery.of(con).size.width;

class _carga_manual extends State<Carga_manual> {
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
        children: [
          SizedBox(
            height: 15,
          ),
          Row(children: [
            SelecRefeArtic(),
            SizedBox(
              width: mq * .02,
            ),
            SizedBox(
              width: mq * .2,
              height: mq * .14,
              child: TextField(
                decoration: InputDecoration(
                  labelText: 'Código',
                  border: OutlineInputBorder(),
                ),
              ),
            ),
            SizedBox(
              width: mq * .02,
            ),
            SizedBox(
              width: mq * .6,
              height: mq * .14,
              child: TextField(
                decoration: InputDecoration(
                  labelText: 'Nombre articulo',
                  border: OutlineInputBorder(),
                ),
              ),
            ),
          ]),
          SizedBox(
            height: 5,
          ),
          Row(
            children: [
              Expanded(
                  child: ListTile(
                title: Text('Cantidad'),
                subtitle: TextFormField(
                  decoration: const InputDecoration(
                    border: OutlineInputBorder(
                        borderRadius: BorderRadius.all(Radius.circular(8))),
                    hintText: 'Cantidad',
                  ),
                ),
              )),
              SizedBox(
                width: 5,
              ),
              Expanded(
                child: ListTile(
                  title: Text('Lote'),
                  subtitle: TextFormField(
                    decoration: const InputDecoration(
                      border: OutlineInputBorder(
                          borderRadius: BorderRadius.all(Radius.circular(8))),
                      hintText: 'Núm lote',
                    ),
                  ),
                ),
              )
            ],
          )
        ],
      ),
    );
  }
}

class SelecRefeArtic extends StatefulWidget {
  const SelecRefeArtic({super.key});

  @override
  State<SelecRefeArtic> createState() => _SelecRefeArticState();
}

class _SelecRefeArticState extends State<SelecRefeArtic> {
  String dropdownValue = list.first;

  @override
  Widget build(BuildContext context) {
    return DropdownButton<String>(
      value: dropdownValue,
      elevation: 16,
      onChanged: (String? value) {
        // This is called when the user selects an item.
        setState(() {
          dropdownValue = value!;
        });
      },
      items: list.map<DropdownMenuItem<String>>((String value) {
        return DropdownMenuItem<String>(
          value: value,
          child: Text(value),
        );
      }).toList(),
    );
  }
}
