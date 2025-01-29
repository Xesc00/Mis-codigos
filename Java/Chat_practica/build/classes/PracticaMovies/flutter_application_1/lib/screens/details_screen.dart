import 'package:flutter/material.dart';
import 'package:practica_final_2/models/models.dart';
import 'package:practica_final_2/screens/providers/movies_provider.dart';
import 'package:practica_final_2/widgets/widgets.dart';

class DetailsScreen extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    // Rep els parametres per context de la pelicula que s'ha elegit i es guarde dedins un objecte movie
    Movie peli = ModalRoute.of(context)!.settings.arguments as Movie;

    return Scaffold(
        body: CustomScrollView(
      slivers: [
        //Envi l'objecte rabut a totes les classes que el nececitin
        _CustomAppBar(peli: peli),
        SliverList(
            delegate: SliverChildListDelegate([
          _PosterAndTitile(peli: peli),
          _Overview(peli: peli),
          CastingCards(
            //Aqui envi l'id ja que es lo que he fet que demani el widget de castingCards
            id_movie: peli.id,
          )
        ]))
      ],
    ));
  }
}

class _CustomAppBar extends StatelessWidget {
  Movie peli;
  //Constructor per rebra l'objecte
  _CustomAppBar({required this.peli});

  @override
  Widget build(BuildContext context) {
    // Exactament igual que la AppBaer però amb bon comportament davant scroll
    return SliverAppBar(
      backgroundColor: Colors.indigo,
      expandedHeight: 200,
      floating: false,
      pinned: true,
      flexibleSpace: FlexibleSpaceBar(
        centerTitle: true,
        titlePadding: EdgeInsets.all(0),
        title: Container(
          width: double.infinity,
          alignment: Alignment.bottomCenter,
          color: Colors.black12,
          padding: EdgeInsets.only(bottom: 10),
          child: Text(
            peli.title,
            style: TextStyle(fontSize: 16),
          ),
        ),
        background: FadeInImage(
          placeholder: AssetImage('assets/loading.gif'),
          image: NetworkImage(peli.fullbackdropPath),
          fit: BoxFit.cover,
        ),
      ),
    );
  }
}

class _PosterAndTitile extends StatelessWidget {
  Movie peli;

  _PosterAndTitile({required this.peli});

  @override
  Widget build(BuildContext context) {
    final TextTheme textTheme = Theme.of(context).textTheme;
    return Container(
      margin: EdgeInsets.only(top: 20),
      padding: EdgeInsets.symmetric(horizontal: 20),
      child: Row(
        children: [
          ClipRRect(
            borderRadius: BorderRadius.circular(20),
            child: FadeInImage(
              placeholder: AssetImage('assets/loading.gif'),
              image: NetworkImage(peli.fullPosterPath),
              height: 150,
            ),
          ),
          SizedBox(
            width: 20,
          ),
          Flexible(
            child: Container(
              child: Column(
                children: [
                  Text(
                    peli.title,
                    style: textTheme.headline5,
                    overflow: TextOverflow.ellipsis,
                    maxLines: 2,
                  ),
                  Text(
                    peli.originalTitle,
                    style: textTheme.subtitle1,
                    overflow: TextOverflow.ellipsis,
                    maxLines: 2,
                  ),
                  Row(
                    children: [
                      Icon(Icons.star_outline, size: 15, color: Colors.grey),
                      SizedBox(
                        width: 5,
                      ),
                      Text(peli.voteAverage.toString(),
                          style: textTheme.caption),
                    ],
                  )
                ],
              ),
            ),
          )
        ],
      ),
    );
  }
}

//Classe només per "escriure" la descripcio de la pelicula, que ben pensat només faria falta pasar un string en ves d'un objecte senser
class _Overview extends StatelessWidget {
  Movie peli;

  _Overview({required this.peli});
  @override
  Widget build(BuildContext context) {
    return Container(
      padding: EdgeInsets.symmetric(horizontal: 20, vertical: 10),
      child: Text(
        peli.overview,
        textAlign: TextAlign.justify,
        style: Theme.of(context).textTheme.subtitle1,
      ),
    );
  }
}
