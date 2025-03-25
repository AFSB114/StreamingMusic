import { ReactNode } from "react";
import { SongContext } from "@/context/SongContext";
import { useEntity } from "@/hooks";
import { SongType } from "@/types";
import songMock from "@/mocks/songMock.json";

export const SongProvider = ({ children }: { children: ReactNode }) => {
  const { state, addEntity, deleteEntity, updateEntity, getEntityById } =
    useEntity<SongType>(songMock.songs);

  return (
    <SongContext.Provider
      value={{
        songsList: state,
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
