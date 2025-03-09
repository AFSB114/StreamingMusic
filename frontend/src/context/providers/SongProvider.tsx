import { type ReactNode } from "react";
import { SongContext } from "../SongContext";
import { useEntity } from "@/hooks/useEntity";
import type { songType } from "@/types";
import songMock from "@/mocks/songMock.json";

export const SongProvider = ({ children }: { children: ReactNode }) => {
  const {
    state: songsList,
    addEntity,
    deleteEntity,
    updateEntity,
    getEntityById,
  } = useEntity<songType>(songMock.songs);

  return (
    <SongContext.Provider
      value={{
        songsList,
        addSong: addEntity,
        deleteSong: deleteEntity,
        updateSongsList: updateEntity,
        getSongById: getEntityById,
      }}
    >
      {children}
    </SongContext.Provider>
  );
};