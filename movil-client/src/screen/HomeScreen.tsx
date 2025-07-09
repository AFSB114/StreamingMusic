import { useNavigation } from '@react-navigation/native';
import { Pressable, Text, View } from 'react-native';

export default function HomeScreen() {
  const navigation = useNavigation();

  return (
    <View className="flex-1 items-center justify-center">
      <Text>Home</Text>
      <Pressable
        className="rounded-xl bg-blue-500 px-6 py-3 transition-all duration-100 active:scale-95 active:bg-blue-600"
        onPress={() => {
          navigation.navigate('Settings');
        }}>
        <Text className="text-center text-lg font-semibold text-white">Settings</Text>
      </Pressable>
      <Pressable
        className="rounded-xl bg-blue-500 px-6 py-3 transition-all duration-100 active:scale-95 active:bg-blue-600"
        onPress={() => {
          navigation.navigate('LogForm');
        }}>
        <Text className="text-center text-lg font-semibold text-white">LogForm</Text>
      </Pressable>
    </View>
  );
}
