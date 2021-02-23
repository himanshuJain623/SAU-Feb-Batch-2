import React from 'react';
import 'react-native-gesture-handler';
import {NavigationContainer} from '@react-navigation/native';
import {createBottomTabNavigator} from '@react-navigation/bottom-tabs';
import TopRated from './src/screens/TopRated';
import Upcoming from './src/screens/Upcoming';
import Popular from './src/screens/Popular';
import {StatusBar} from 'react-native';

const Tab = createBottomTabNavigator();

export default function App() {
  return (
    <NavigationContainer>
      <StatusBar
        barStyle="dark-content"
        hidden={false}
        backgroundColor="#00BCD4"
        translucent={true}
      />
      <Tab.Navigator
        initialRouteName="Upcoming"
        tabBarOptions={{
          labelStyle: {
            textTransform: 'none',
            fontWeight: 'bold',
            fontSize: 15,
            marginBottom: 10,
            color:'black'
          },
          style: {
            backgroundColor:'#00BCD4'
          },
        }}>
        <Tab.Screen name="Upcoming" component={Upcoming} />
        <Tab.Screen name="Top Rated" component={TopRated} />
        <Tab.Screen name="Popular" component={Popular} />
      </Tab.Navigator>
    </NavigationContainer>
  );
}
