"use client";
import { GuitarGallery } from "@/app/components/guitars/GuitarGallery";
import { GuitarSelection } from "@/app/components/guitars/GuitarSelection";
import { NavBar } from "@/app/components/navbar/NavBar";

export default function Selection() {
  return (
    <div className="">
      <NavBar />
      <GuitarSelection />
    </div>
  );
}
