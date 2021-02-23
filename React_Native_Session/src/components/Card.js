import React, {useState} from 'react';
import {
  StyleSheet,
  Text,
  View,
  Image,
  TouchableOpacity,
  Modal,
  Button,
} from 'react-native';
import Detail from './Details';

function Card({item, navigation}) {
  let imageUrl = 'https://image.tmdb.org/t/p/w500' + item.poster_path;

  const [modalOpen, setModalOpen] = useState(false);

  const closeModal = () => {
    setModalOpen(false);
  };

  return (
    <View>
      <Modal visible={modalOpen} animationType="slide">
        <Detail item={item} closeModal={closeModal} />
      </Modal>

      <TouchableOpacity style={styles.item} onPress={() => setModalOpen(true)}>
        <Image style={styles.itemImage} source={{uri: imageUrl}} />
        <View>
        <Text style={styles.rating}>Rating: {item.vote_average}</Text>
        <Text style={styles.title}>{item.title}</Text>
        <Text style={styles.date}>({item.release_date})</Text>
        </View>
      </TouchableOpacity>
    </View>
  );
}
// https://image.tmdb.org/t/p/w500/

const styles = StyleSheet.create({
  item: {
    marginBottom: 10,
    marginHorizontal: 5,
    borderRadius: 6,
    elevation: 3,
    shadowOffset: {width: 1, height: 1},
    shadowColor: '#333',
    shadowOpacity: 0.3,
    shadowRadius: 2,
    width: 170,
    paddingTop:7,
    paddingLeft:10,
    paddingBottom:7
  },
  itemImage: {
    width: 150,
    height: 150,
    marginTop:5
  },
  rating:{
    fontWeight:'bold',
    marginBottom:5
  },
  date:{
    color:'grey'
  }
});

export default Card;
