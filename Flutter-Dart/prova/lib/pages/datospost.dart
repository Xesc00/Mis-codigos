import 'dart:convert';

class Datos_Post {
  Datos_Post(
      {this.id,
      required this.titulo,
      required this.foto,
      required this.descripcion});

  int? id;
  String titulo;
  String foto;
  String descripcion;

  factory Datos_Post.fromJson(Map<String, dynamic> json) => Datos_Post(
        id: json['id'],
        titulo: json['titulo'],
        foto: json['foto'],
        descripcion: json['descripcion'],
      );

  Map<String, dynamic> toMap() => {
        "id": id,
        "titol": titulo,
        "foto": foto,
        "descripcion": descripcion,
      };
}
