import 'dart:io';

import 'package:path/path.dart';
import 'package:path_provider/path_provider.dart';
import 'package:sqflite/sqflite.dart';

import '../moodels/cast_despesa.dart';

class DBProvider {
  static Database? _database;
  static final DBProvider db = DBProvider._();

  DBProvider._();

  Future<Database> get database async {
    if (_database == null) _database = await initDB();

    return _database!;
  }

  Future<Database> initDB() async {
    Directory documentsDirectory = await getApplicationDocumentsDirectory();

    final path = join(documentsDirectory.path, 'Despeses.db');
    print(path);

    return await openDatabase(path, version: 1, onOpen: (db) {},
        onCreate: (Database db, int version) async {
      await db.execute('''
        CREATE TABLE Despeses(
          id INTEGER PRIMARY KEY,
          titol TEXT,
          quantitat TEXT
        )
        ''');
    });
  }

  Future<int> inserRawDespesa(Despesa novaDespese) async {
    final id = novaDespese.id;
    final titol = novaDespese.titol;
    final quantitat = novaDespese.quantitat;

    final db = await database;

    final res = await db.rawInsert('''
    INSERT INTO Despeses(id, titol, quantitat)
    VALUES ($id, $titol, $quantitat)
    ''');

    return res;
  }

  Future<int> insertDespesa(Despesa novaDespese) async {
    final db = await database;

    final res = await db.insert('Despeses', novaDespese.toMap());
    print(res);
    return res;
  }

  Future<List<Despesa>> getAllDespeses() async {
    final db = await database;
    final res = await db.query('Despeses');

    return res.isNotEmpty ? res.map((e) => Despesa.fromMap(e)).toList() : [];
  }

  Future<Despesa?> getDespesaById(int id) async {
    final db = await database;
    final res = await db.query('Despeses', where: 'id = ?', whereArgs: [id]);

    if (res.isNotEmpty) return Despesa.fromMap(res.first);
    return null;
  }

  Future<int> updateDespesa(Despesa novaDespese) async {
    final db = await database;
    final res = await db.update('Despeses', novaDespese.toMap(),
        where: 'id = ?', whereArgs: [novaDespese.id]);

    return res;
  }

  Future<int> deleteAllDespesa() async {
    final db = await database;
    final res = await db.rawDelete('''
      DELETE FROM Despeses
    ''');

    return res;
  }

  Future<int> deleteDespesa(int? id) async {
    final db = await database;
    final res = await db.rawDelete('''
      DELETE FROM Despeses WHERE id = $id
    ''');

    return res;
  }
}
