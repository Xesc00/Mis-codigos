import 'package:flutter/material.dart';
import 'package:practica_final_2/widgets/buscador.dart';
import 'package:practica_final_2/widgets/widgets.dart';

import 'dart:convert' as convert;

import 'package:provider/provider.dart';

import 'providers/movies_provider.dart';

class HomeScreen extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    final moviesProvider = Provider.of<MovieProvider>(context);
    final popularMProvider = Provider.of<MovieProvider>(context);
  
    return Scaffold(
        appBar: AppBar(
          title: Text('Cartellera'),
          elevation: 0,
          actions: [
            IconButton(onPressed: () {
              showSearch(context: context, delegate: Buscador(movies: moviesProvider.onDisplayMOvie));
            }, icon: Icon(Icons.search_outlined))
          ],
        ),
        body: SingleChildScrollView(
            child: Container(
          child: Column(
            children: [
              // Targetes principals
              CardSwiper(movies: moviesProvider.onDisplayMOvie),

              // Slider de pel·licules
              MovieSlider(pmovies: popularMProvider.onDisplayPopularMovie),
              // Poodeu fer la prova d'afegir-ne uns quants, veureu com cada llista és independent
              // MovieSlider(),
              // MovieSlider(),
            ],
          ),
        )));
  }
}
