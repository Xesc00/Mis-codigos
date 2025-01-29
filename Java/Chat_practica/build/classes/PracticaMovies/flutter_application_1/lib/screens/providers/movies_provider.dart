import 'package:flutter/cupertino.dart';
import 'dart:convert' as convert;
import 'package:http/http.dart' as http;
import 'package:practica_final_2/models/models.dart';

class MovieProvider extends ChangeNotifier {
  String _baseUrl = "api.themoviedb.org";
  String _apiKey = "939eb80dfbdd3aec99c4daf98a2d44e1";
  String _lenguage = "es-ES";
  String _page = "1";

  //Llista de pelicules recents
  List<Movie> onDisplayMOvie = [];
  //Llista de pelicules populars
  List<Movie> onDisplayPopularMovie = [];
  //Llista de actors
  Map<int, List<Cast>> onDisplayCast = {};

  MovieProvider() {
    print('Movie Provider inicialitzat!');
    this.getOnDisplayMode();
    this.getOnDisplayPopularMode();
  }

  //Envai la llista de pelicules partinent a la url que li pasa
  getOnDisplayMode() async {
    print('getOnDiplayMode');

    var url = Uri.https(_baseUrl, '/3/movie/now_playing',
        {'api_key': _apiKey, 'language': _lenguage, 'page': _page});

    final result = await http.get(url);

    final nowPlayingResponse = NowPlayingResponse.fromJson(result.body);

    onDisplayMOvie = nowPlayingResponse.results;

    notifyListeners();
  }

  //Envai la llista de pelicules populars 
  getOnDisplayPopularMode() async {
    print('getOnDisplayPopularMode');

    var url = Uri.https(_baseUrl, '3/movie/popular',
        {'api_key': _apiKey, 'language': _lenguage, 'page': _page});

    final result = await http.get(url);

    final PopularResponse = Popular_Response.fromJson(result.body);

    onDisplayPopularMovie = PopularResponse.results;
  }

  //Envia una llista de actors 
  Future <List<Cast>> getCastMode(int id_movie) async {
    var url = Uri.https(_baseUrl, '/3/movie/${id_movie}/credits',
        {'api_key': _apiKey, 'language': _lenguage});

    final result = await http.get(url);

    final castResponse = CastResponse.fromJson(result.body);

    onDisplayCast[id_movie] = castResponse.cast;

    return castResponse.cast;
  }
}
