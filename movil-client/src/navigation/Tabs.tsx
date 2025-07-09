import { createBottomTabNavigator } from '@react-navigation/bottom-tabs';
import HomeScreen from '~/screen/HomeScreen';
import SettingsScreen from '~/screen/SettingsScreen';
import FontAwesome from '@expo/vector-icons/FontAwesome';

const tab = createBottomTabNavigator();

export default function Tabs() {
  return (
    <tab.Navigator>
      <tab.Screen
        name="Home"
        component={HomeScreen}
        options={{ tabBarIcon: () => <FontAwesome name="home" size={24} color="black" /> }}
      />
      <tab.Screen
        name="Settings"
        component={SettingsScreen}
        options={{ tabBarIcon: () => <FontAwesome name="cog" size={24} color="black" /> }}
      />
    </tab.Navigator>
  );
}
