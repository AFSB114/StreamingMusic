import { ReactNode } from "react";
import { ArtistContext } from "@/context/ArtistContext";
import { useEntity } from "@/hooks";
import { ArtistType } from "@/types";

export const ArtistProvider = ({ children }: { children: ReactNode }) => {
  const apiUrl = process.env.NEXT_PUBLIC_API_URL
  const { state, addEntity, deleteEntity, updateEntity, getEntityById, searchEntityBy } =
    useEntity<ArtistType>(`${apiUrl}/artist`, "artists");

  return (
    <ArtistContext.Provider
      value={{
        artistsList: state,
        addArtist: addEntity,
        deleteArtist: deleteEntity,
        updateArtist: updateEntity,
        getArtistById: getEntityById,
        searchArtists: searchEntityBy,
      }}
    >
      {children}
    </ArtistContext.Provider>
  );
};
