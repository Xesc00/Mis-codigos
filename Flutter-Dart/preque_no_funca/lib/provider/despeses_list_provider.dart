import 'package:flutter/cupertino.dart';

import '../moodels/cast_despesa.dart';
import 'despeses_db.dart';

class DespesasListProvider extends ChangeNotifier {
  List<Despesa> despeses = [];

  Future<Despesa> novaDespesa(String titol) async {
    final novaDespesa = Despesa(titol: titol, quantitat: '100');
    final id = await DBProvider.db.insertDespesa(novaDespesa);

    novaDespesa.id = id;

    despeses.add(novaDespesa);
    notifyListeners();

    return novaDespesa;
  }

  carregarDespeses() async {
    final despeses = await DBProvider.db.getAllDespeses();
    this.despeses = [...despeses];
    notifyListeners();
  }

  esborrarTots() async {
    final despeses = await DBProvider.db.deleteAllDespesa();
    this.despeses = [];
    notifyListeners();
  }

  esborrarPerID(int i) async {
    final despeses = await DBProvider.db.deleteDespesa(i);
    this.despeses = [];
    notifyListeners();
  }
}
