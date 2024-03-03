import { useParams } from "next/navigation";
import React, { useEffect, useState } from "react";

export const TunerGallery = () => {
  const [tuners, setTuners] = useState<Guitar[]>([]);
  const [isLoading, setIsloading] = useState<boolean>(true);

  useEffect(() => {
    const fetchTuners = async () => {
      const response = await fetch(`http://localhost:8080/api/v1/tuners`);
      const jsonResponse = await response.json();
      setTuners(jsonResponse.guitars);
      setIsloading(false);
    };
    fetchTuners();
  }, []);
  return (
    <div>
      <h1></h1>
    </div>
  );
};
