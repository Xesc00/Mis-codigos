import 'package:flutter/material.dart';
import 'package:practica_final_2/models/models.dart';
import 'package:practica_final_2/screens/providers/movies_provider.dart';
import 'package:provider/provider.dart';

class CastingCards extends StatelessWidget {
  //Rep un int que peratany a una pelicula per poder fer la reserca de actors
  final int id_movie;

  const CastingCards({Key? key, required this.id_movie}) : super(key: key);
  
  
  @override
  Widget build(BuildContext context){
    
    final movieProivder = Provider.of<MovieProvider>(context,listen: false);

    return FutureBuilder(
    future: movieProivder.getCastMode(id_movie),
    builder: (BuildContext context, AsyncSnapshot<List<Cast>> snapshot) {
      if(!snapshot.hasData){
        return Container(
          child: Center(
            child: CircularProgressIndicator(),
          ),
        );
      }
    
      final casting = snapshot.data;
      
      return Container(
        margin: EdgeInsets.only(bottom: 30),
        width: double.infinity,
        height: 180,
        // color: Colors.red,
        child: ListView.builder(
            itemCount: 10,
            scrollDirection: Axis.horizontal,
            itemBuilder: (BuildContext context, int index) => _CastCard(cast: casting![index])),
      );
      },
    );
  }
}

class _CastCard extends StatelessWidget {
  final Cast cast;
  const _CastCard({required this.cast});
  
  @override
  Widget build(BuildContext context) {
    print(cast.name);
    return Container(
      margin: EdgeInsets.symmetric(horizontal: 10),
      width: 110,
      height: 100,
      // color: Colors.green,
      child: Column(
        children: [
          ClipRRect(
            borderRadius: BorderRadius.circular(20),
            child: FadeInImage(
              placeholder: AssetImage('assets/no-image.jpg'),
              image: NetworkImage(cast.fullprofilePath),
              height: 140,
              width: 100,
              fit: BoxFit.cover,
            ),
          ),
          SizedBox(
            height: 5,
          ),
          Text(
            cast.name,
            maxLines: 2,
            overflow: TextOverflow.ellipsis,
            textAlign: TextAlign.center,
          )
        ],
      ),
    );
  }
}
