import React from 'react';
import {StyleSheet, Text, View, FlatList} from 'react-native';
import Card from './Card';

function List(props) {
  return (
    <FlatList
      numColumns={2}
      keyExtractor={(item) => item.id.toString()}
      data={props.movies.results}
      renderItem={({item}) => {
        return <Card item={item}/>;
      }}
    />
  );
}

export default List;
