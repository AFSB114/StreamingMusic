import { ReactNode } from "react";
import { AlbumContext } from "@/context/AlbumContext";
import { useEntity } from "@/hooks";
import { AlbumType } from "@/types";

export const AlbumProvider = ({ children }: { children: ReactNode }) => {
  const apiUrl = process.env.NEXT_PUBLIC_API_URL
  const { state, addEntity, deleteEntity, updateEntity, getEntityById, searchEntityBy } =
    useEntity<AlbumType>(`${apiUrl}/album`, "albums");

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