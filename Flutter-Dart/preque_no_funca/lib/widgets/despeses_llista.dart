import 'package:flutter/cupertino.dart';
import 'package:flutter/material.dart';
import 'package:provider/provider.dart';

import '../provider/despeses_list_provider.dart';

class DespesesTitles extends StatelessWidget {
  const DespesesTitles({Key? key}) : super(key: key);

  @override
  Widget build(BuildContext context) {
    final despesesListProvider = Provider.of<DespesasListProvider>(context);
    final despeses = despesesListProvider.despeses;

    return ListView.builder(itemCount: despeses.length,
      itemBuilder: (_,index) => Dismissible(
        key: UniqueKey(),
        background: Container(color: Colors.purpleAccent,
        child: Align(
          child: Padding(
            padding: const EdgeInsets.all(8.0),
            child: Icon(Icons.delete_forever),
          ),
          alignment: Alignment.centerRight,
        ),),
        onDismissed: (DismissDirection direccio) {
          Provider.of<DespesasListProvider>(context, listen: false).esborrarPerID(despeses[index].id!);
        },
        child: ListTile(
          leading: Icon(Icons.map_outlined),
          title: Text('${despeses[index].titol} ${despeses[index].quantitat}'),
          subtitle: Text(despeses[index].id.toString()),
          trailing: Icon(Icons.arrow_right),
        ),
      )
      );
  }
}
