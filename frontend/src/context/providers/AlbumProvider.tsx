import { ReactNode } from "react";
import { AlbumContext } from "@/context/AlbumContext";
import { useEntity } from "@/hooks";
import { AlbumType } from "@/types";

export const AlbumProvider = ({ children }: { children: ReactNode }) => {
  const { state, addEntity, deleteEntity, updateEntity, getEntityById, searchEntityBy } =
    useEntity<AlbumType>("http://localhost:8085/api/v1/album");

  return (
    <AlbumContext.Provider
      value={{
        albumsList: state,
        addAlbum: addEntity,
        deleteAlbum: deleteEntity,
        updateAlbum: updateEntity,
        getAlbumById: getEntityById,
        searchAlbums: searchEntityBy,
      }}
    >
      {children}
    </AlbumContext.Provider>
  );
};