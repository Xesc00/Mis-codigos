import 'package:flutter/material.dart';
import 'package:practica_final_2/models/models.dart';


//Calsse per el sercador
class Buscador extends SearchDelegate{
  final List<Movie> movies;

  //Constructor per fer que rebi una llista de pelicules
  Buscador({required this.movies});

  @override
  List<Widget>? buildActions(BuildContext context) {
    return [IconButton(icon: Icon(Icons.clear),
     onPressed: (){
       query = '';
    } )];
  }

  @override
  Widget? buildLeading(BuildContext context) { 
    return IconButton(
      icon: Icon(Icons.arrow_back),
      onPressed: (){}
    );
  }

  @override
  Widget buildResults(BuildContext context) {
    final List<Movie> allMovies = movies.where(
        (pelicula) => pelicula.title.toLowerCase().contains(
          query.toLowerCase(),
        ),
      ).toList();
    return ListView.builder(
      itemCount: allMovies.length,
      itemBuilder: (context, index) => ListTile(
        title: Text(allMovies[index].title),
      )
    );
  }

  @override
  Widget buildSuggestions(BuildContext context) {
    final List<Movie> allMovies = movies.where(
        (pelicula) => pelicula.title.toLowerCase().contains(
          query.toLowerCase(),
        ),
      ).toList();
    
    //Llista de pelicules que es veuran en els ercador i les seves respectives actualitzacions
    return ListView.builder(
      itemCount: allMovies.length,
      itemBuilder: (context, index) => Container(
        child: Row(
        children: [
          GestureDetector(
            onTap: () =>
                Navigator.pushNamed(context, 'details', arguments: allMovies[index]),
            child: ClipRRect(
              borderRadius: BorderRadius.circular(10),
              child: FadeInImage(
                placeholder: AssetImage('assets/no-image.jpg'),
                image: NetworkImage(allMovies[index].fullPosterPath),
                width: 60,
                height: 70,
                fit: BoxFit.cover,
              ),
            ),
            
          ),
          Text(
                    allMovies[index].title,
                    overflow: TextOverflow.ellipsis,
                    maxLines: 2,
                  ),
        ]
      )
    )
    );
  }

}