"use client";
import { GuitarGallery } from "@/app/components/guitars/GuitarGallery";
import { NavBar } from "@/app/components/navbar/NavBar";

export default function Guitars({
  params,
}: {
  params: { guitarType: string };
}) {
  return (
    <div className="">
      <NavBar />
      <GuitarGallery type={params.guitarType} />
    </div>
  );
}
