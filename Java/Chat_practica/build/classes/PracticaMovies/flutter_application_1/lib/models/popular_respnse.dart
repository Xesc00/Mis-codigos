import 'package:practica_final_2/models/models.dart';

class Popular_Response {
  Popular_Response({
    required this.page,
    required this.results,
    required this.totalPages,
    required this.totalResults,
  });

  int page;
  List<Movie> results;
  int totalPages;
  int totalResults;

  factory Popular_Response.fromJson(String str) =>
      Popular_Response.fromMap(json.decode(str));

  String toJson() => json.encode(toMap());

  factory Popular_Response.fromMap(Map<String, dynamic> json) =>
      Popular_Response(
        page: json["page"],
        results: List<Movie>.from(json["results"].map((x) => Movie.fromMap(x))),
        totalPages: json["total_pages"],
        totalResults: json["total_results"],
      );

  Map<String, dynamic> toMap() => {
        "page": page,
        "results": List<dynamic>.from(results.map((x) => x.toMap())),
        "total_pages": totalPages,
        "total_results": totalResults,
      };
}
