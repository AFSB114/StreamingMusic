import { createNativeStackNavigator } from "@react-navigation/native-stack";
import HomeScreen from "~/screen/HomeScreen";
import LogFormScreen from "~/screen/LogFormScreen";
import SettingsScreen from "~/screen/SettingsScreen";

const Stack = createNativeStackNavigator();

export default function Stacks() {
  return (
    <Stack.Navigator initialRouteName="Home">
      <Stack.Screen name="Home" component={HomeScreen} />
      <Stack.Screen name="Settings" component={SettingsScreen} />
      <Stack.Screen name="LogForm" component={LogFormScreen} />
    </Stack.Navigator>
  );
}