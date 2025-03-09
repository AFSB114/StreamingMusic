"use client";

import type { ArtistType, ArtistContextType } from "@/types";
import {
  createContext,
  useState,
  useContext,
  useCallback,
  ReactNode,
} from "react";

import artistMock from "@/mocks/artistMock.json";

// Crea el contexto con un valor inicial tipado
const ArtistContext = createContext<ArtistContextType | undefined>(undefined);

export const ArtistProvider = ({ children }: { children: ReactNode }) => {
  const [artistsList, setArtistsList] = useState<ArtistType[]>(artistMock.artists);

  // Eliminar una canción por ID
  const deleteArtist = useCallback((id: number) => {
    setArtistsList((prevArtists) => {
      const updatedArtists = prevArtists.filter((artist) => artist.id !== id);
      return updatedArtists;
    });
  }, []);

  // Obtener una canción por ID
  const getArtistById = useCallback(
    (id: number) => {
      return artistsList.find((artist) => artist.id === id) || null;
    },
    [artistsList]
  );

  // Actualizar una canción existente
  const updateArtist = useCallback(
    (id: number, updatedArtist: Partial<ArtistType>) => {
      setArtistsList((prevArtists) => {
        const updatedArtists = prevArtists.map((artist) =>
          artist.id === id ? { ...artist, ...updatedArtist } : artist
        );
        return updatedArtists;
      });
    },
    []
  );

  // Agregar una nueva canción
  const addArtist = useCallback(
    (newArtist: Omit<ArtistType, "id">) => {
      // Genera un nuevo ID basado en el máximo ID existente + 1
      const newId =
        artistsList.length > 0
          ? Math.max(...artistsList.map((artist) => artist.id)) + 1
          : 1;

      const artistWithId = {
        ...newArtist,
        id: newId,
      };

      setArtistsList([...artistsList, artistWithId]);
      return newId; // Devuelve el ID generado por si es necesario
    },
    [artistsList]
  );

  return (
    <ArtistContext.Provider
      value={{
        artists: artistsList,
        setArtists: setArtistsList,
        deleteArtist,
        getArtistById,
        updateArtist,
        addArtist,
      }}
    >
      {children}
    </ArtistContext.Provider>
  );
};

export const useArtist = (): ArtistContextType => {
  const context = useContext(ArtistContext);
  if (context === undefined) {
    throw new Error("useArtist must be used within a ArtistProvider");
  }
  return context;
};
