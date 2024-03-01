import React, { useEffect, useState } from "react";
import { GuitarCard } from "./GuitarCard";
import { Guitar } from "@/app/types/Types";

export const GuitarGallery = () => {
  const [guitars, setGuitars] = useState<Guitar[]>([]);
  const [isLoading, setIsloading] = useState<boolean>(true);
  useEffect(() => {
    const fetchGuitars = async () => {
      const response = await fetch("http://localhost:8080/api/v1/guitars");
      const jsonResponse = await response.json();
      setGuitars(jsonResponse.guitars);
      setIsloading(false);
    };
    fetchGuitars();
  }, []);

  return (
    <div>
      {isLoading ? (
        <img className="h-20 mx-auto my-40" src="/loading.gif" />
      ) : (
        guitars.map((guitar, index) => (
          <GuitarCard guitar={guitar} key={index} />
        ))
      )}
    </div>
  );
};
