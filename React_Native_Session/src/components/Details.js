import React from 'react';
import {StyleSheet, Text, View, Image, Button} from 'react-native';

function Detail({item, closeModal}) {
  let imageUrl = 'https://image.tmdb.org/t/p/w500' + item.poster_path;
  return (
    <View style={styles.main}>
      <View style={styles.header}>
        <View style={styles.heading}>
          <Text style={styles.title}>{item.title}</Text>
          <View style={styles.ratingContainer}>
            <Text style={styles.rating}>Rating</Text>
            <Text style={styles.rating}>{item.vote_average}</Text>
          </View>
        </View>
        <Text style={styles.date}>({item.release_date})</Text>
      </View>

      <Image style={styles.itemImage} source={{uri: imageUrl}} />

      <Text>{item.overview}</Text>

      <View style={styles.footer}>
        <View>
          <Text>Votes</Text>
          <Text style={styles.footerText}>{item.vote_count}</Text>
        </View>

        <View>
          <Text>Language</Text>
          <Text style={styles.footerText}>{item.original_language}</Text>
        </View>
        <View>
          <Text>Popularity</Text>
          <Text style={styles.footerText}>{item.popularity}</Text>
        </View>
      </View>

      <Button
        onPress={() => {
          closeModal();
        }}
        title="close"
        color="#841584"
        accessibilityLabel="Go back to the movies list"
      />
    </View>
  );
}

const styles = StyleSheet.create({
  main: {
    marginTop: 20,
    marginLeft: 5,
    marginRight: 5,
  },
  header: {
    marginBottom: 20,
  },
  heading: {
    flexDirection: 'row',
    justifyContent: 'space-between',
    alignItems: 'center',
  },
  title: {
    fontSize: 30,
    fontWeight: 'bold',
    color: '#136cb2',
    width: 300,
  },
  ratingContainer:{
    alignItems:'center'
  },
  rating: {
    fontSize: 15,
    fontWeight: 'bold',
    marginRight: 15,
  },
  date: {
    color: 'grey',
  },
  itemImage: {
    width: 350,
    height: 350,
    marginBottom: 20,
    borderRadius: 5,
  },
  footer: {
    flexDirection: 'row',
    justifyContent: 'space-between',
    alignItems: 'center',
    marginBottom:20,
    marginTop:20
  },
  footerText: {
    color: 'grey',
    width: 80,
  },
});

export default Detail;
