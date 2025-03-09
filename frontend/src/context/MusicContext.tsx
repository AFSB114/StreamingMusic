"use client";

import type { Song, MusicContextType } from '@/utils/const.def';
import { createContext, useState, useContext, useCallback, ReactNode } from 'react';
import songs from "@/mocks/songs.json";

// Crea el contexto con un valor inicial tipado
const MusicContext = createContext<MusicContextType | undefined>(undefined);

export const MusicProvider = ({ children }: { children: ReactNode }) => {
  const [musics, setMusics] = useState<Song[]>(songs.songs);

  // Eliminar una canción por ID
  const deleteMusic = useCallback((id: number) => {
    setMusics(prevMusics => {
      const updatedMusics = prevMusics.filter(song => song.id !== id);
      return updatedMusics;
    });
  }, []);

  // Obtener una canción por ID
  const getMusicById = useCallback((id: number) => {
    return musics.find(song => song.id === id) || null;
  }, [musics]);

  // Actualizar una canción existente
  const updateMusic = useCallback((id: number, updatedSong: Partial<Song>) => {
    setMusics(prevMusics => {
      const updatedMusics = prevMusics.map(song => 
        song.id === id ? { ...song, ...updatedSong } : song
      );
      return updatedMusics;
    });
  }, []);

  // Agregar una nueva canción
  const addMusic = useCallback((newSong: Omit<Song, 'id'>) => {
    // Genera un nuevo ID basado en el máximo ID existente + 1
    const newId = musics.length > 0 
      ? Math.max(...musics.map(song => song.id)) + 1 
      : 1;
    
    const songWithId = {
      ...newSong,
      id: newId
    };
    
    setMusics(prevMusics => [...prevMusics, songWithId]);
    return newId; // Devuelve el ID generado por si es necesario
  }, [musics]);

  return (
    <MusicContext.Provider value={{ 
      musics, 
      setMusics, 
      deleteMusic, 
      getMusicById, 
      updateMusic, 
      addMusic 
    }}>
      {children}
    </MusicContext.Provider>
  );
};

export const useMusic = (): MusicContextType => {
  const context = useContext(MusicContext);
  if (context === undefined) {
    throw new Error('useMusic must be used within a MusicProvider');
  }
  return context;
};