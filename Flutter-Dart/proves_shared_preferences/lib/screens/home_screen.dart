import 'package:flutter/material.dart';
import 'package:provider/provider.dart';

import 'list_screen.dart';
import 'screens.dart';

class HomeScreen extends StatelessWidget {
  static Route<dynamic> route(String mensaje) {
    return MaterialPageRoute(
      builder: (context) => HomeScreen(mensaje: mensaje),
    );
  }

  final String mensaje;

  const HomeScreen({Key? key, required this.mensaje}) : super(key: key);

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: Text('Inici'),
        actions: [
          IconButton(
            icon: Icon(Icons.delete_forever),
            onPressed: () {
              // TODO: Esborrar tot
            },
          )
        ],
      ),
      body: Column(
        mainAxisAlignment: MainAxisAlignment.center,
        children: <Widget>[
          Row(
            mainAxisAlignment: MainAxisAlignment.center,
            children: <Widget>[
              Text(
                mensaje,
                style: TextStyle(
                  fontSize: 32.0,
                  fontStyle: FontStyle.italic,
                  fontWeight: FontWeight.bold,
                ),
                textAlign: TextAlign.center,
              ),
            ],
          )
        ],
      ),
      floatingActionButton: FloatingActionButton(
        onPressed: () {
          print('Botó polsat!');
          String barCode = "Elden Ring";

          // final despesListProvider =
          //     Provider.of<DespesasListProvider>(context, listen: false);

          // despesListProvider.novaDespesa(barCode);
        },
        backgroundColor: Colors.green,
        child: const Icon(Icons.add),
      ),
    );
  }
}

// class _HomeScreenBody extends StatelessWidget {
//   const _HomeScreenBody({Key? key}) : super(key: key);

//   @override
//   Widget build(BuildContext context) {
//     final scanListProvider = Provider.of<DespesasListProvider>(context);

//     scanListProvider.carregarDespeses();
//     return DespesesScreen();
//   }
// }
