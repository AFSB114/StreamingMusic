import { NavigationContainer } from "@react-navigation/native";
import Tabs from "./Tabs";
import Stacks from "./Stacks";


export default function Navigation() {
  return (
    <NavigationContainer>
      <Stacks />
    </NavigationContainer>
  );
}