import { useState } from 'react';
import { View, Text, TextInput } from 'react-native';

interface FormType {
  email: string;
  password: string;
}

export default function LogFormScreen() {
  
  const [form, setForm] = useState<FormType>({
    email: '',
    password: '',
  });

  const handleChange = (field: string, text: string) => {
    setForm({ ...form, [field]: text });
  };

  return (
    <View className='flex-1 items-center justify-center'>
      <View className=''>
        <Text>Password</Text>
        <TextInput
          className='mt-5 border-2 border-gray-300 rounded-lg p-2'
          placeholder='Password'
          onChangeText={(text) => handleChange('password', text)}
          value={form.password}
          secureTextEntry
        />
      </View>
    </View>
  );
}