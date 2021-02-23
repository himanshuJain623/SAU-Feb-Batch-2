import React, {useEffect, useState} from 'react';
import {StyleSheet, Text, View} from 'react-native';
import List from '../components/List';

function TopRated() {
  const [topRatedMovies, setTopRatedMovies] = useState([]);

  const getTopRatedMovies = async () => {
    try {
      const url =
        'https://api.themoviedb.org/3/movie/top_rated?api_key=fe4c4372217c7188089f334449eacc5b&language=en-US&page=1&region=Us';
      const resp = await fetch(url);
      setTopRatedMovies(await resp.json());
    } catch (err) {
      console.log('topRated movies fetching error ------ ');
      console.log(err);
    }
  };

  useEffect(() => {
    getTopRatedMovies();
  }, []);

  return (
    <View style={styles.MainView}>
      <Text style={styles.titleText}>Top Rated Movies</Text>
      <List movies={topRatedMovies}></List>
    </View>
  );
}


const styles = StyleSheet.create({
  MainView: {
    flex: 1,
    alignItems: 'center',
  },
  titleText: {
    fontSize: 30,
    marginTop: 50,
    marginBottom: 20,
  },
});

export default TopRated;
